
# Step 1: Build the Angular application
FROM node:18-alpine AS builder
WORKDIR /app
COPY package*.json /app/
RUN npm install -g @angular/cli
RUN npm install
COPY . /app
RUN ng build --configuration "production"

# Step 2: Serve the Angular app from Nginx
FROM nginx:alpine
RUN apk --no-cache add curl
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/dist/skowly-ui /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
