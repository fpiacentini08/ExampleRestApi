# ExampleRestApi
Example Rest Api in Vertex 3

Listens in port 8080. You can execute this by doing `mvn clean install` and then executing the fat jar created in the target folder.

Example of response:

```
curl -v http://localhost:8080
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET / HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.64.1
> Accept: */*
>
< HTTP/1.1 200 OK
< Content-Length: 49
<
* Connection #0 to host localhost left intact
<h1>Hello from my first Vert.x 3 application</h1>* Closing connection 0
```
