from flask import Flask, request
from python_clarifai import clarifai_api_call
from python_clarifai.util import json_response

from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route('/picture/upload', methods=['POST'])
@json_response
def label_img_result():
    content = request.get_json()
    return clarifai_api_call.get_main_info_from_labeler(content['currentPicture'])


if __name__ == '__main__':
    app.run()
