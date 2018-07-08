<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#btn1").linkbutton({
            text:"提交",
            onClick:function(){
                $("#ff").form("submit",{
                    url:"${pageContext.request.contextPath}/picture/addPicture",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#dd").dialog("close");
                        $("#picture").datagrid({
                            url:"${pageContext.request.contextPath}/picture/getAllPicture",
                        });
                    }
                });
            }
        });
        $("#btn2").linkbutton({
            text:"取消",
            onClick:function(){
                $("#dd").dialog("close");
            }
        });

    });
</script>
<form id="ff" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>上传轮播图:</td>
            <td><input class="easyui-filebox" name="file" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>轮播图描述:</td>
            <td><input class="easyui-textbox" name="pictureDescription" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>轮播图状态:</td>
            <td>
                <select class="easyui-combobox" name="pictureStatus" style="width:150px;">
                    <option value="0">未展示</option>
                    <option value="1">展示中</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><a id="btn1"></a></td>
            <td><a id="btn2"></a></td>
        </tr>
    </table>
</form>