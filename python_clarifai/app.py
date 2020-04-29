from flask import Flask, request
from python_clarifai import clarifai_api_call
from python_clarifai.util import json_response
from flask_cors import CORS
import base64

#app = Flask(__name__)
#CORS(app)


#@app.route('/picture/upload', methods=['POST'])
#@json_response
def label_img_result():
    with open("tesztalany1.jpg", "rb") as image_file:
        return clarifai_api_call.get_main_info_from_labeler(image_file)


if __name__ == '__main__':
    print(label_img_result())
