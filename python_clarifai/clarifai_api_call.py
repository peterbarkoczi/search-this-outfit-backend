import os
from clarifai.rest import ClarifaiApp
from clarifai.rest import Image, Model

app = ClarifaiApp(api_key=os.environ.get('API_KEY'))
model = Model(app.api, model_id='72c523807f93e18b431676fb9a58e6ad')


def api_get_label_information(image_byte_array):
    return model.predict(
        [Image(base64=image_byte_array)])


def get_main_info_from_labeler(image_byte_array):
    result = api_get_label_information(image_byte_array)
    main_information = result.get("outputs")[0].get("data").get("regions")
    object_list = {}
    counter = 1
    for r in main_information:
        object_list[counter] = [r.get("data").get("concepts")[0].get("name"), r.get("region_info").get("bounding_box")]
        counter += 1
        print(f'Object parameters {r.get("region_info").get("bounding_box")} '
              f'Object name {r.get("data").get("concepts")[0].get("name")}')

    return object_list
