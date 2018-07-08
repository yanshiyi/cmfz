<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#picture").datagrid({
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            toolbar:"#td",
            url:"${pageContext.request.contextPath}/picture/getAllPicture",
            columns:[[
                {field:"pictureId",title:"编号",align:"center"},
                {field:"pictureName",title:"名称",align:"center",sortable:true},
                {field:"pictureDate",title:"创建时间",align:"center",sortable:true},
                {field:"pictureDescription",title:"描述信息",align:"center",sortable:true},
                {field:"pictureStatus",title:"轮播图状态",sortable:true,align:"center",formatter: function(value,row,index){
                         if (value=="1"){
                             return "展示中";
                         } else {
                             return "未展示";
                         }
                     }
                },

            ]],
            view:detailview,
            pagination:true,
            pageList:[5,10],
            pageSize:5,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picturePath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            },
        });


    });


    function add(){
        $("#dd").dialog({
            title: "新增轮播图",
            width: 400,
            height: 250,
            closed: false,
            modal: true,
            minimizable:true,
            maximizable:true,
            collapsible:true,
            href:"${pageContext.request.contextPath}/main/addPicture.jsp",
        });
    }
    function modify(){
        var rowData = $("#picture").datagrid("getSelected");
        $("#dd").dialog({
            title: "修改信息",
            width: 400,
            height: 200,
            closed: false,
            modal: true,
            href:"${pageContext.request.contextPath}/main/modifyPicture.jsp",
            onLoad:function(){
                $("#ff").form("load",rowData);
            },
        });
    }

</script>

<table id="picture"></table>
<div id="td" style="display:none">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改轮播图'" onclick="modify()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'" onclick="add()"></a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>
<div id="dd" style="display:none;"align="center">
</div>