<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#guru_btn1").linkbutton({
            text:"提交",
            onClick:function(){
                $("#guru_ff1").form("submit",{
                    url:"${pageContext.request.contextPath}/guru/addGuru",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#guru_dd").dialog("close");
                        $("#guru").datagrid({
                            url:"${pageContext.request.contextPath}/guru/getAllGuru",
                        });
                    }
                });
            }
        });
        $("#guru_btn2").linkbutton({
            text:"取消",
            onClick:function(){
                $("#guru_dd").dialog("close");
            }
        });

    });
</script>
<form id="guru_ff1" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上师名称:</td>
            <td><input class="easyui-textbox" name="guruName" style="width: 150px;" /></td>
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
            <td><a id="guru_btn1"></a></td>
            <td><a id="guru_btn2"></a></td>
        </tr>
    </table>
</form>