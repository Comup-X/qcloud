import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import App from './App.vue'

import VueRouter from 'vue-router'
import routes from './routes'
import cos from './cos'
import axios from 'axios'

import cosUpload from './CosUpload.vue'

Vue.prototype.cos = cos;

axios.defaults.baseURL = 'http://127.0.0.1:8080';
// axios.defaults.headers.post['Content-Type'] = 'multipart/form-data';
Vue.prototype.axios = axios;

Vue.use(VueRouter);
Vue.use(ElementUI);
Vue.component('cos-upload', cosUpload);

const router = new VueRouter({
    routes
});

new Vue({
    router,
    render: h => h(App)
}).$mount('#app');