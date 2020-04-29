from flask import Flask, request
from util import json_response
import clarifai_api_call
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
