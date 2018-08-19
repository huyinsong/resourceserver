# resourceserver
## RUN tips
   - 1 Run with spring boot
   - 2 open restapi client and fill in information below:
  
        url: http://localhost:8080/hello
        method: get
        header : Authorization Bearer ${token}
   - Attention: 
   
     Do not fill in Basic Auth username and password. Otherwise the spring security will use BasicAuthenticationFilter rather than OAuthAuthticationFilter.
     
## Notice: Using buildship to build gradle project
    You can download buildship from eclipse Marketplate.