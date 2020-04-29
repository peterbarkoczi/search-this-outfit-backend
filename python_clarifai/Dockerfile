FROM python:3.6
WORKDIR /pythonbackend
ENV API_KEY 7ae25c4275344908a46664907e0a35d4
ENV FLASK_APP app.py
ENV FLASK_RUN_HOST 0.0.0.0
COPY requirements.txt requirements.txt
RUN pip install -r requirements.txt
COPY . .
CMD ["flask", "run"]