<html lang="en">
<head>
    <title>Latest</title>
</head>
<body>
    <#list codes as code>
        <span id="load_date">${code.getDate()}</span>
        <pre id="code_snippet">${code.getCode()}</pre>
        <br>
    </#list>
</body>
</html>