<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function(){
        $("#pic_btn3").linkbutton({
            text:"提交",
            onClick:function(){
                $("#pic_ff2").form("submit",{
                    url:"${pageContext.request.contextPath}/picture/modifyPicture",
                    onSubmit:function(){
                        return true;
                    },
                    success:function(res){
                        $("#pic_dd").dialog("close");
                        $("#picture").datagrid({
                            url:"${pageContext.request.contextPath}/picture/getAllPicture",
                        });
                    },
                });
            }
        });
        $("#pic_btn4").linkbutton({
            text:"取消",
            onClick:function(){
                $("#pic_dd").dialog("close");
            }
        });

    });
</script>
<form id="pic_ff2" method="post">
        <table>
        <tr>
            <td>轮播图ID:</td>
            <td><input class="easyui-textbox" name="pictureId" style="width: 150px;" readonly="true"/></td>
        </tr>
        <tr>
            <td>轮播图名称:</td>
            <td><input class="easyui-textbox" name="pictureName" style="width: 150px;"/></td>
        </tr>
        <tr>
            <td>轮播图路径:</td>
            <td><input class="easyui-textbox" name="picturePath" style="width: 150px;" readonly="true"/></td>
        </tr>
        <tr>
            <td>轮播图描述:</td>
            <td><input class="easyui-textbox" name="pictureDescription" style="width: 150px;" /></td>
        </tr>
        <tr>
            <td>轮播图创建时间:</td>
            <td><input class="easyui-textbox" name="pictureDate" style="width: 150px;" readonly="true"/></td>
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
            <td><a id="pic_btn3"></a></td>
            <td><a id="pic_btn4"></a></td>
        </tr>
    </table>
</form>