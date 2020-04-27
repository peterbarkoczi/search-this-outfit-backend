import os

from clarifai.rest import ClarifaiApp
from clarifai.rest import Image, Model

app = ClarifaiApp(api_key=os.environ.get('API_KEY'))
model = Model(app.api, model_id='72c523807f93e18b431676fb9a58e6ad')


def api_get_label_information():
    return model.predict(
        [Image(url="https://fdcdn.akamaized.net/m/780x1132/products/27078/27077975/images/res_cf5b6c13e3f5c35f38883c576d9fb090.jpg?s=0vYjpVNpDinn")])


def get_main_info_from_labeler():
    result = api_get_label_information()
    main_information = result.get("outputs")[0].get("data").get("regions")
    object_list = {}
    counter = 1
    for r in main_information:
        object_list[counter] = [r.get("data").get("concepts")[0].get("name"), r.get("region_info").get("bounding_box")]
        counter += 1
        print(f'Object parameters {r.get("region_info").get("bounding_box")} '
              f'Object name {r.get("data").get("concepts")[0].get("name")}')

    return object_list
