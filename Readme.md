
#Api Details 200 Success 
--http://localhost:8080/getCountryCodesList/"US"
--http://localhost:8080/getCountryCodesList/"US","CA"

#404 API notfound

---http://localhost:8080/getCountryCodesList/
---http://localhost:8080/getCountryCodesLi/

#Placed Logging level AS WARn 

#created docker  image and pushed to dockerhub by using google jib plugin
 #DockerHUb repo link
----shivamontreal/takehome:0.0.2-SNAPSHOT

docker pull command -- docker pull shivamontreal/takehome:latest
docker pull shivamontreal/takehome:0.0.2-SNAPSHOT

#Local build and run application 
  Please comment build.gradle file line no 50-53 auth {} block
  to successfully build and deploy



