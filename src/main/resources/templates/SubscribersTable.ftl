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

<h3>Subscribers</h3>
<br>
<div>

    <table class="table table-dark">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>surname</th>
            <th>tel.</th>
            <th>address</th>
            <th>idNumber</th>
            <th>description</th>
            <th>delete</th>
            <th>edit</th>
        </tr>
        <#list subscribers as element> <!--цикл по всем айтемам -->
<#--      для каждого айтем каторый мы получили из контроллера-->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.sureName}</td>
                <td>${element.tel}</td>
                <td>${element.address}</td>
                <td>${element.idNumber}</td>
                <td>${element.description}</td>
                <td><a href="/web/subscriber/delete/${element.id}"><button type="button" class="btn btn-light">delete</button></a> </td>
                <td><a href="/web/subscriber/edit/${element.id}"><button type="button" class="btn btn-info">edit</button></a> </td>


            </tr>
        </#list>
    </table>

</div>
<a href="/index.html">back</a>




</body>
</html>
