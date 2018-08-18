package Utility;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonResponseParser {
    private static final String JSON_FIELD_NAME = "Name";
    private static final String JSON_FIELD_DESCRIPTION = "Description";
    private static final String JSON_FIELD_PROMOTIONS = "Promotions";
    private static final String JSON_FIELD_CAN_RELIST = "CanRelist";
    private JsonElement rootElement;

    public JsonResponseParser(String jsonString){
        JsonParser jsonParser=new JsonParser();
        rootElement = jsonParser.parse(jsonString);
    }

    private JsonObject getJsonRootObject(){
        JsonObject rootJson=null;
        if(rootElement.isJsonObject())
           rootJson= rootElement.getAsJsonObject();
        return rootJson;
    }

    public Boolean isCanResist(){
        return getJsonRootObject().get(JSON_FIELD_CAN_RELIST).getAsBoolean();
    }

    public String getNameFromRootObject(){
        return getJsonRootObject().get(JSON_FIELD_NAME).getAsString();
    }

    private JsonArray getPromotions(){
        JsonArray arrPromotions;
        arrPromotions=getJsonRootObject().get(JSON_FIELD_PROMOTIONS).getAsJsonArray();
        return arrPromotions;
    }

    private JsonObject getPromotionwithName(String promotionName){
        String name;
        JsonObject jsonObjectPromotion=null;
        for (JsonElement elePromotion: getPromotions()) {
            name = elePromotion.getAsJsonObject().get(JSON_FIELD_NAME).getAsString();
            if (name.compareTo(promotionName) == 0)
                jsonObjectPromotion= (JsonObject) elePromotion;
        }
        return jsonObjectPromotion;
    }

    public String getPromotionDescriptionWithName(String promotionName){
        return getPromotionwithName(promotionName).get(JSON_FIELD_DESCRIPTION).getAsString();
    }









}
