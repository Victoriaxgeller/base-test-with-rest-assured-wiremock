package api.swagger.fake.steps;

import api.swagger.fake.model.Pet;
import com.google.gson.Gson;
import api.common.RequestBuilder;
import api.swagger.fake.req.specification.SwaggerFakeApiClient;

public class PetSteps {

    SwaggerFakeApiClient swaggerFakeApiClient = new SwaggerFakeApiClient();
    Gson gson = new Gson();


    public Pet getPetById(int id) {
        RequestBuilder requestBuilder = RequestBuilder.builder().path("/pet")
                .pathParamName("petId")
                .pathParamValue(String.valueOf(id)).build();
        return swaggerFakeApiClient.getRequestWithPathParam(requestBuilder).body().as(Pet.class);
    }

    public Pet addNewPet(Pet pet) {
        return swaggerFakeApiClient.postRequest(gson.toJson(pet)).body().as(Pet.class);
    }

    public Pet updatePet(Pet pet) {
        return swaggerFakeApiClient.putRequest(gson.toJson(pet)).body().as(Pet.class);
    }
}
