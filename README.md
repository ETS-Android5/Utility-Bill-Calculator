# Utility Bill Calculator
This was my University final year project. The logic has been rewritten and the app is now connected to my back-end which retrieves latest bill prices.
The project is a utility bill calculator that can be used as a financial planning application. It calculates Malaysia bill prices using their native value.

# Library Used Other Than From Android
1. Jackson (Convert JSON to POJO)
2. Android Async HTTP (HTTP connection library)

# How to connect to the back end
1. Download and run the main application here https://github.com/Fariz-01/MalaysiaBillPriceAPI
2. In the logic package, there is an UpdateBillPrice class, change the ip address in the client.get("YourIpGoesHere", new TextHttpResponseHandler() {code} ) to your local ip address.

