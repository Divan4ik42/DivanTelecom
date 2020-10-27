<#--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
</head>
<body>

</body>
</html>-->


<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Item</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>List</h3>
<br>
<div>
<#--<a href="http://localhost:8080/">Create</a>-->
    <table class="table table-dark">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>created</th>
            <th>modified</th>
            <th>delete</th>
            <th>edit</th>
        </tr>
        <#list Items as element> <!--цикл по всем айтемам -->
<#--      для каждого айтем каторый мы получили из контроллера-->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/item/delete/${element.id}"><button type="button" class="btn btn-light">delete</button></a> </td>
                <td><a href="/web/item/edit/${element.id}"><button type="button" class="btn btn-info">edit</button></a> </td>


            </tr>
        </#list>
    </table>

</div>

<a href="/index.html">back</a><#--
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items</title>
</head>
<body>

</body>
</html>-->


<#import "/spring.ftl" as spring/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Item</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>List</h3>
<br>
<div>
    <a href="/web/item/create">Create</a>
    <table class="table table-dark">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>description</th>
            <th>created</th>
            <th>modified</th>
            <th>delete</th>
            <th>edit</th>
        </tr>
        <#list Items as element> <!--цикл по всем айтемам -->
        <#--      для каждого айтем каторый мы получили из контроллера-->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/item/delete/${element.id}"><button type="button" class="btn btn-light">delete</button></a> </td>
                <td><a href="/web/item/edit/${element.id}"><button type="button" class="btn btn-info">edit</button></a> </td>


            </tr>
        </#list>
    </table>
    <a href="/web/item/create/"><button type="button" class="btn btn-light">Create</button></a>

</div>

<a href="/index.html">back</a>





</body>
</html>





</body>
</html>
