package steps;

import com.google.gson.Gson;
import io.restassured.response.Response;
import model.Pet;
import req.specification.RequestBuilder;
import req.specification.RestRequest;

public class PetSteps {

    RestRequest restRequest = new RestRequest();
    Gson gson = new Gson();


    public Pet getPetById(int id) {
        RequestBuilder requestBuilder = new RequestBuilder().setRelativePath("/pet")
                .setPathParamName("petId")
                .setPathParamValue(String.valueOf(id));
        return restRequest.getRequestWithPathParam(requestBuilder).body().as(Pet.class);
    }

    public Pet addNewPet(Pet pet) {
        return restRequest.postRequest(gson.toJson(pet)).body().as(Pet.class);
    }

    public Pet updatePet(Pet pet) {
        return restRequest.putRequest(gson.toJson(pet)).body().as(Pet.class);
    }
}
