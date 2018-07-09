<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" isELIgnored="false" language="java" %>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript">
    $(function(){
            var E = window.wangEditor;
            var editor = new E('#editor');
            editor.customConfig.uploadImgServer = '${pageContext.request.contextPath}/article/upload'
            editor.customConfig.uploadFileName = 'files'
            editor.create()


            $('#article_guru').combobox({
                url:"${pageContext.request.contextPath}/guru/getGuruIdAndName",
                valueField:'guruId',
                textField:'guruName',
            });

            $("#art_btn1").linkbutton({
                text:"提交",
                onClick:function(){
                    $("#article_ff").form("submit",{
                        url:"${pageContext.request.contextPath}/article/addArticle",
                        onSubmit:function(param){
                            param.articleContent=editor.txt.html();
                            return true;
                        },
                        success: function(){
                            $("#article_ff").form("clear");
                            editor.txt.clear();
                            $('#article_guru').combobox({
                                url:"${pageContext.request.contextPath}/guru/getGuruIdAndName",
                                valueField:'guruId',
                                textField:'guruName',
                            });
                        }

                    });
                }

            });
            $("#art_btn2").linkbutton({
                text:"重置",
                onClick:function(){
                    $("#article_ff").form("clear");
                    editor.txt.clear();
                }
            });
    });
</script>
<form id="article_ff" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>文章标题：<input class="easyui-textbox" name="articleName"></td>
        </tr>
        <tr>
            <td>上师：<input id="article_guru" class="easyui-combobox" name="guruId"></td>
        </tr>
        <tr>
            <td>
                <div id="editor">
                    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <a id="art_btn1" class="easyui-linkbutton"/>
                <a id="art_btn2" class="easyui-linkbutton"/>
            </td>
        </tr>
    </table>
</form>

