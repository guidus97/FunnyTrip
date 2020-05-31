FROM node:latest

WORKDIR /usr/node/src

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 3009

RUN cd /usr/node/src/main

CMD ["node","index.js","3009"]