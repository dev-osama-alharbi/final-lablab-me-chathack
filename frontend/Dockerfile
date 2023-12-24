#FROM node:latest as build
#WORKDIR /usr/local/app
#COPY ./ /usr/local/app/
#RUN npm install
#RUN npm run build
# docker tag sha256:6f47503d3d832aa311a11535d606fd43257ef04ed6739a6387470233843d53d0 osam0/lablabf:latest
# docker push osam0/lablabf:latest
FROM nginx:latest
COPY ./dist/chatcraft-frontend/browser /usr/share/nginx/html
#COPY --from=build /usr/local/app/dist/chatcraft-frontend/browser /usr/share/nginx/html
EXPOSE 80
