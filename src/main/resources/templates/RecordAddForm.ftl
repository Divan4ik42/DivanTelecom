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
        <legend>Add Record</legend>
        <form name="record" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            Start:<@spring.formInput "form.start" "" "date"/>
            <br>
            Finish:<@spring.formInput "form.finish" "" "date"/>
            <br>
            Subscriber:<@spring.formSingleSelect "form.subscriber", subscribers, ""/>
            <br>

            <input type="submit" value="Create"/>
        </form>
    </fieldset>
</div>

</body>
</html>