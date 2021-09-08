
public class API {


//    @Ignore
//    public void createDeal() {
//
//        for (int i = 0; i < 7000; i++) {
//
//
//            given()
//                    .contentType("application/x-www-form-urlencoded")
//                    .cookie("snov_io=eMOnKInfTcAd2LXllxQgGnHmIhSXYLSIb86kiQqj; Path=/; Secure; HttpOnly;")
//                    .body("name=ApiDeal " + getRandomInt(1, 10000) + "&" +
//                            "funnelId=5035&" +
//                            "funnelStatusId=25173&" +
//                            "responsibleUserId=396abdfa8429d00ef47bf1297ff50e275a8c1c54a8906460e1b056384b5e39&" +
//                            "companyId&1111&" +
//                            "dealStatus=active&" +
//                            "price=100&" +
//                            "peopleId=988118dd9e02053ba6fdca6a95c1216c9af4b839f441ea2a250575fe76dc3d6092b69f23")
//                    .when()
//                    .post("https://preprod.snov.io/crm/api/deals")
//                    .then().log().body()
//                    .statusCode(200)
//                    .extract().response();
//
//
//        }
//    }


    // Verifier


    /**
     public void updateFunnelStatus() {


     given()
     .contentType("application/x-www-form-urlencoded")
     .cookie("snov_io=RsQZWWXs7EaphOE3ddUaPobzoSxRfMY33Ig5MvXw; Path=/; Secure; HttpOnly;")
     .body(
     "funnelId=5035&" +
     "funnelStatusId=25173&" +
     "dealStatus=active&"



     )
     .when()
     .put("https://preprod.snov.io/crm/api/deals/update-funnel-status")
     .then().log().body()
     .statusCode(200)
     .extract().response();
     }
     **/
}
