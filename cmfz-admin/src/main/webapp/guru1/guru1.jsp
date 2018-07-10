<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" language="java" %>
<script type="text/javascript">
    $(function(){
        $("#guru").datagrid({
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            toolbar:"#guru_td",
            url:"${pageContext.request.contextPath}/guru/getAllGuru",
            columns:[[
                {field:"guruId",title:"上师编号",align:"center"},
                {field:"guruName",title:"上师法名",align:"center",sortable:true},
                {field:"guruDesc",title:"上师简介",align:"center",sortable:true},
            ]],
            view:detailview,
            pagination:true,
            pageList:[5,10],
            pageSize:5,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/guru/' + rowData.guruPhoto + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
        });

        $("#guru_batch").linkbutton({
            onClick:function(){
              $("#guru_dd").dialog({
                  title:"批量上传",
                  width:350,
                  height:300,
                  closed:false,
                  modal:true,
                  minimizable:true,
                  maximizable:true,
                  collapsible:true,
                  href:"${pageContext.request.contextPath}/guru1/guruBatch.jsp",
              });
            },
        });
    });


    function addGuru(){
        $("#guru_dd").dialog({
            title: "新增上师",
            width: 400,
            height: 250,
            closed: false,
            modal: true,
            minimizable:true,
            maximizable:true,
            collapsible:true,
            href:"${pageContext.request.contextPath}/guru1/addGuru.jsp",
        });
    }
    function modifyGuru(){
        var rowData = $("#guru").datagrid("getSelected");
        $("#guru_dd").dialog({
            title: "修改信息",
            width: 400,
            height: 200,
            closed: false,
            modal: true,
            href:"${pageContext.request.contextPath}/guru1/modifyGuru.jsp",
            onLoad:function(){
                $("#guru_ff2").form("load",rowData);
            },
        });
    }


    function qq(value,name){
        console.log("value="+value);
        console.log("name="+name);
        $("#guru").datagrid("reload","${pageContext.request.contextPath}/guru/getGuruByKey?name="+name+"&value="+value);
    }
</script>

<table id="guru"></table>
<div id="guru_td" style="display:none">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改上师'" onclick="modifyGuru()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'" onclick="addGuru()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
    <a id="guru_batch" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'批量插入'"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true,text:'导出'" href="${pageContext.request.contextPath}/guru/export"></a>
    <input class="easyui-searchbox" style="width:300px" data-options="searcher:qq,prompt:'请输入模糊条件',menu:'#guru_mm'"/>
    <div id="guru_mm" style="width:120px">
        <div data-options="name:'guru_name'">上师法名</div>
        <div data-options="name:'guru_desc'">上师描述</div>
    </div>
</div>
<div id="guru_dd" style="display:none;"align="center">
</div>