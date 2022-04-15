<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet"
       target="_blank" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
    <title>Code</title>
</head>
<body>
<span id="load_date">${code.getDate()}</span>
<#if code.getViews() != 0>
<br/><span id="views_restriction">${code.getViews()} more views allowed</span>
</#if>
<#if code.getTime() != 0>
<br/><span id="time_restriction">The code will be available for ${code.getTime()} seconds</span>
</#if>
<pre id="code_snippet"><code>${code.getCode()}</code></pre>
</body>
</html>