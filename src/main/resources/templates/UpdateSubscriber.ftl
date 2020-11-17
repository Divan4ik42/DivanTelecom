<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Update Subscriber</legend>
        <form name="item" action="" method="POST">

            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Gender:<@spring.formInput "form.gender" "" "text"/>
            <br>
            sureName:<@spring.formInput "form.sureName" "" "text"/>
            <br>
            tel:<@spring.formInput "form.tel" "" "text"/>
            <br>
            address:<@spring.formInput "form.address" "" "text"/>
            <br>
            idNumber:<@spring.formInput "form.idNumber" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>


            <input type="submit" value="update"/>
        </form>
    </fieldset>
</div>

</body>
</html>