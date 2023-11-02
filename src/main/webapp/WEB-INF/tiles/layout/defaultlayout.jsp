<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
    <div class="flex-container">
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <article class="article">
		    <tiles:insertAttribute name="body" />
        </article>
    <tiles:insertAttribute name="footer" />
    </div>
</body>
</html>