<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styleSheet1.css" type="text/css">
        <title>JUMSトップ</title>
    </head>
    <body>
        <div class="base">
            <h1>ユーザー情報管理トップ</h1><br>
            <h3>ここでは、ユーザー情報管理システムとしてユーザー情報の登録や検索、
                付随して修正や削除を行うことができます</h3><br>

            <table width="100%" align="center"><tr><td>    
                        <form action="Insert" method="POST">
                            <input type="submit" name="yes" value="新規登録">
                        </form>
                    </td>
                    <td>
                        <form action="Search" method="POST">
                            <input type="submit" name="yes" value="検索(修正・削除)">
                        </form>
                    </td></tr>
            </table>
        </div>
    </body>
</html>
