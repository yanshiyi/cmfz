<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#log").datagrid({
            width:500,
            height:250,
            remoteSort:false,
            singleSelect:true,
            nowrap:false,
            fitColumns:true,
            fit:true,
            url:"${pageContext.request.contextPath}/log/getAllLog",
            columns:[[
                {field:"logId",title:"编号",align:"center"},
                {field:"logUser",title:"用户",align:"center",sortable:true},
                {field:"logTime",title:"时间",align:"center",sortable:true},
                {field:"logAction",title:"操作",align:"center",sortable:true},
                {field:"logResource",title:"对象",align:"center",sortable:true,},
                {field:"logMessage",title:"参数",align:"center",sortable:true,},
                {field:"logResult",title:"结果",align:"center",sortable:true,},
            ]],
            pagination:true,
            pageList:[5,10],
            pageSize:5,
        });
    });

</script>

<table id="log"></table>
</div>