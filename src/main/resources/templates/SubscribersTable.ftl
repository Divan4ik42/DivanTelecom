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

<h3>Subscribers</h3>
<br>
<div>
    <fieldset>
        <legend>Search</legend>
        <form name="subscriber" action="" method="POST">
            Search:<@spring.formInput "search.name" "" "text"/>
            <input type="submit" value="Search"/>
        </form>
    </fieldset>
</div>
<div class="dropdown">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
        Sort by
    </button>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

        <button class="btn dropdown-item" onclick="window.location.href='/web/subscriber/list/sortbyid'">ID</button>
        <button class="btn dropdown-item" onclick="window.location.href='/web/subscriber/list/sort'">Name</button>
        <button class="btn dropdown-item" onclick="window.location.href='/web/subscriber/list/sortbydate'">Modified</button>
    </div>
    <div>
        <div>

            <table class="table table-dark">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>surname</th>
                    <th>tel.</th>
                    <th>address</th>
                    <th>idNumber</th>
                    <th>description</th>
                    <th>delete</th>
                    <th>update</th>
                </tr>
                <#list subscribers as element> <!--цикл по всем айтемам -->
                <#--      для каждого айтем каторый мы получили из контроллера-->
                    <tr>
                        <td>${element.id}</td>
                        <td>${element.name}</td>
<#--                        <td>-</td>-->
                        <td>${element.gender}</td>
                        <td>${element.sureName}</td>
                        <td>${element.tel}</td>
                        <td>${element.address}</td>
                        <td>${element.idNumber}</td>
                        <td>${element.description}</td>
                        <td><a href="/web/subscriber/delete/${element.id}">
                                <button type="button" class="btn btn-light">delete</button>
                            </a></td>
                        <td><a href="/web/subscriber/update/${element.id}">
                                <button type="button" class="btn btn-info">edit</button>
                            </a></td>
                    </tr>
                </#list>
            </table>

        </div>
        <a href="/index.html">back</a>
        <div>

            <a href="/web/subscriber/create/">
                <button type="button" class="btn btn-light">Create</button>
            </a>
            <button onclick="window.location.href='/web/subscriber/list'">bug fixer</button>

        </div>
    </div>
</div>
</body>
</html>
