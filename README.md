# CodeSharingPlatform
Code Sharing Platform with Spring Boot REST/MVC/JPA

##### Description

Programming is full of little secrets. Sometimes, even within the same company, there is some secret code that should be hidden from most of the colleagues. This piece of code should only be available to certain people, and it may be deleted in the future to hide the traces.

There are two limitations on the code snippet's visibility:

1.  **A limit on the number of views** will allow viewing the snippet only a certain number of times, after which the snippet is deleted from the database.
2.  **A limit on the viewing time** will allow viewing a code snippet for a certain period of time, and after its expiration, the code snippet is deleted from the database.

If both restrictions are applied to a certain code snippet, it has to be deleted when at least one of these limits is reached.

Obviously, the hidden pieces of code should not be shown on the `GET /code/latest` page or available by the `GET /api/code/latest` request. They should only be available through a link. So, remember that **the latest snippets should not contain any restrictions**.

##### Objectives

In this stage, your program should support the same endpoints as in the previous stage. Here is what's going to be different:

*   Code snippets should be accessible via UUID links. `POST /api/code/new` should return a UUID of the snippet instead of a number.  
    
*   `POST /api/code/new` should take a JSON object with a field `code` and two other fields:  
    1\. `time` field contains the time (in seconds) during which the snippet is accessible.  
    2\. `views` field contains a number of views allowed for this snippet.  
    Remember, that 0 and negative values should correspond to the absence of the restriction.  
    
*   `GET /code/new` should contain two elements on top of the others:  
    1\. `<input id="time_restriction" type="text"/>` should contain the time restriction.  
    2\. `<input id="views_restriction" type="text"/>` should contain the views restriction  
      
    Remember that POST request should contain numbers, not strings.  
    
*   `GET /api/code/latest` and `GET /code/latest` should not return any restricted snippets.  
    
*   `GET /api/code/UUID` should not be accessible if one of the restrictions is triggered. Return `404 Not Found` in this case and all the cases when no snippet with such a UUID was found.  
    
*   `GET /api/code/UUID` should show what restrictions apply to the code piece. Use the keys `time` and `views` for that. A zero value (0) should correspond to the absence of the restriction.  
    1\. `time` field contains the time (in seconds) during which the snippet is accessible.  
    2\. `views` field shows how many additional views are allowed for this snippet (excluding the current one).  
    
*   `GET /code/UUID` should contain the following elements:  
    1.`<span id="time_restriction"> ... </span>` in case the time restriction is applied.  
    2\. `<span id="views_restriction"> ... </span>` in case the views restriction is applied.  
      
    Note: if only one of the restrictions is applied, you should show only one of the above elements.

##### Examples

In the following examples, consider that no code snippets have been uploaded beforehand.

**Example 1**

Request `POST /api/code/new` with the following body:

    {
        "code": "class Code { ...",
        "time": 0,
        "views": 0
    }

Response: `{ "id" : "7dc53df5-703e-49b3-8670-b1c468f47f1f" }`.

Request `POST /api/code/new` with the following body:

    {
        "code": "public static void ...",
        "time": 0,
        "views": 0
    }

Response: `{ "id" : "e6780274-c41c-4ab4-bde6-b32c18b4c489" }`.

Request `POST /api/code/new` with the following body:

    {
        "code": "Secret code",
        "time": 5000,
        "views": 5
    }

Response: `{ "id" : "2187c46e-03ba-4b3a-828b-963466ea348c" }`.

**Example 2**

Request: `GET /api/code/2187c46e-03ba-4b3a-828b-963466ea348c`

Response:

    {
        "code": "Secret code",
        "date": "2020/05/05 12:01:45",
        "time": 4995,
        "views": 4
    }

Another request `GET /api/code/2187c46e-03ba-4b3a-828b-963466ea348c`

Response:

    {
        "code": "Secret code",
        "date": "2020/05/05 12:01:45",
        "time": 4991,
        "views": 3
    }

**Example 3**

Request: `GET /code/2187c46e-03ba-4b3a-828b-963466ea348c`

Response:

![](https://ucarecdn.com/236ce1cf-524c-49be-909c-eeccee0ffa53/)

**Example 4**

Request: `GET /api/code/latest`

Response:

    [
        {
            "code": "public static void ...",
            "date": "2020/05/05 12:00:43",
            "time": 0,
            "views": 0
        },
        {
            "code": "class Code { ...",
            "date": "2020/05/05 11:59:12",
            "time": 0,
            "views": 0
        }
    ]

**Example 5**

Request: `GET /code/latest`

Response:

![](https://ucarecdn.com/8b62a89d-3cb8-4093-a7e8-8e63cadbf1fd/)

**Example 6**

Request: `GET /code/new`

Response:

![](https://ucarecdn.com/a6ff06f0-ed0a-43d9-8893-2b0cd68b694b/)
