from flask import Flask
from util import json_response
import clarifai_api_call

app = Flask(__name__)


@app.route('/picture/upload', methods=['POST'])
@json_response
def label_img_result(image_byte_array):
    return clarifai_api_call.get_main_info_from_labeler(image_byte_array)


if __name__ == '__main__':
    app.run()
