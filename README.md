# Utility Bill Calculator
This is a financial planner application that calculates Malaysia utlility bill prices using their native value.

# Libraries
1. Jackson (JSON to POJO)
2. Android Async HTTP (HTTP connection library)

# How to connect to the back end
1. Download, modify the application.properties according to the instruction and run the main application here https://github.com/Fariz-01/MalaysiaBillPriceAPI
2. In the logic package, there is an UpdateBillPrice class, change the ip address to your local ip address.
```
client.get("YourIpGoesHere/api/electric|water/id", new TextHttpResponseHandler() {code} )
```
All api endpoints can be viewed in the README here https://github.com/Fariz-01/MalaysiaBillPriceAPI

