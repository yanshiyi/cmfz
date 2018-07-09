<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#guru_btn3").linkbutton({
            text:"提交",
            onClick:function(){
                $("#guru_ff2").form("submit",{
                    url:"${pageContext.request.contextPath}/guru/modifyGuru",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#guru_dd").dialog("close");
                        $("#guru").datagrid({
                            url:"${pageContext.request.contextPath}/guru/getAllGuru",
                        });
                    },
                });
            }
        });
        $("#guru_btn4").linkbutton({
            text:"取消",
            onClick:function(){
                $("#guru_dd").dialog("close");
            }
        });

    });
</script>
<form id="guru_ff2" method="post" enctype="multipart/form-data">
        <table>
        <tr>
            <td>上师编号:</td>
            <td><input class="easyui-textbox" name="guruId" style="width: 150px;" readonly="true"/></td>
        </tr>
        <tr>
            <td>上师法名:</td>
            <td><input class="easyui-textbox" name="guruName" style="width: 150px;"/></td>
        </tr>
        <tr>
            <td>上师头像:</td>
            <td><input class="easyui-filebox" name="file" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>上师简介:</td>
            <td><input class="easyui-textbox" name="guruDesc" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td><a id="guru_btn3"></a></td>
            <td><a id="guru_btn4"></a></td>
        </tr>
    </table>
</form>