#stage 1
FROM node:10.23.2 as node
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build 
#stage 2
FROM nginx:alpine
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=node /app/dist/notepad-app /usr/share/nginx/html
