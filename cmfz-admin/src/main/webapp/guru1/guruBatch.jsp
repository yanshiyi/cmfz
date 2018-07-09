<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#guru_btn5").linkbutton({
            text:"提交",
            onClick:function(){
                $("#guru_ff3").form("submit",{
                    url:"${pageContext.request.contextPath}/guru/addBatch",
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
        $("#guru_btn6").linkbutton({
            text:"取消",
            onClick:function(){
                $("#guru_dd").dialog("close");
            }
        });

    });

</script>
<form id="guru_ff3" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>请选择Excel文件：</td>
            <td>
                <div>
                    <input class="easyui-filebox" style="width:200" name="file">
                </div>
            </td>
        </tr>
        <tr>
            <td><a id="guru_btn5"></a></td>
            <td><a id="guru_btn6"></a></td>
        </tr>
    </table>
</form>

