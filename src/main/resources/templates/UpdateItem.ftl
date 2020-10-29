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
        <legend>Add Item</legend>
        <form name="item" action="" method="POST">

            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
<#--            Created:<@spring.formInput "form.created_at" "" "text"/>-->
<#--            <br>-->
<#--            Modified:<@spring.formInput "form.modified_at" "" "text"/>-->
<#--            <br>-->

            <input type="submit" value="update"/>
        </form>
    </fieldset>
</div>

</body>
</html>