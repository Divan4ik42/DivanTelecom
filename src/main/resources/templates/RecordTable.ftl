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
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>List</h3>
<br>

<#--<div>-->
<#--    <fieldset>-->
<#--        <legend>Search</legend>-->
<#--        <form name="item" action="" method="POST">-->
<#--            Search:<@spring.formInput "search.name" "" "text"/>-->
<#--            <input type="submit" value="Search"/>-->
<#--        </form>-->
<#--    </fieldset>-->
<#--</div>-->
<br>

<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
        Sort by
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

        <button class="btn dropdown-item" onclick="window.location.href='/web/item/list/sortbyid'">ID</button>
        <button class="btn dropdown-item" onclick="window.location.href='/web/item/list/sort'">Name</button>
        <button class="btn dropdown-item" onclick="window.location.href='/web/item/list/sortbydate'">Modified</button>
    </div>
    <br>
    <div>

        <#--<a href="http://localhost:8080/">Create</a>-->
        <table class="table table-dark">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>description</th>
                <th>start</th>
                <th>finish</th>
                <th>subscriber</th>
                <th>build</th>
                <th>created</th>
                <th>modified</th>
                <th>delete</th>
                <th>edit</th>
            </tr>
            <#list records as element> <!--цикл по всем айтемам -->
            <#--      для каждого айтем каторый мы получили из контроллера-->
                <tr>
                    <td>${element.id}</td>
                    <td>${element.name}</td>
                    <td>${element.description}</td>
                    <td>${element.start}</td>
                    <td>${element.finish}</td>
                    <td>${element.subscriber.name}</td>
                    <td>${element.build.name}</td>
                    <td>${element.created_at}</td>
                    <td>${element.modified_at}</td>
                    <td><a href="/web/item/delete/${element.id}">
                            <button type="button" class="btn btn-light">delete</button>
                        </a></td>
                    <td><a href="/web/item/update/${element.id}">
                            <button type="button" class="btn btn-info">edit</button>
                        </a></td>
                </tr>
            </#list>
        </table>
    </div>
    <br>


</div>
<div>

    <a href="/web/record/create/">
        <button type="button" class="btn btn-light">Create</button>
    </a>

</div>
<br>
<button onclick="window.location.href='/web/record/list'">bug fixer</button>
<br>

<a href="/index.html">back</a>


</body>
</html>
