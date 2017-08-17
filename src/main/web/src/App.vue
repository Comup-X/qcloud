<template>
    <div id="app">
        <h1>人脸识别DEMO</h1>
        <p>
            <!-- 使用 router-link 组件来导航. -->
            <!-- 通过传入 `to` 属性指定链接. -->
            <!-- <router-link> 默认会被渲染成一个 `<a>` 标签 -->
            <router-link to="/faceCompare">人脸对比</router-link>
            <router-link to="/identifyPerson">人脸检索</router-link>
            <router-link to="/createPerson">创建个体</router-link>
        </p>
        <!-- 路由出口 -->
        <!-- 路由匹配到的组件将渲染在这里 -->
        <router-view id="view"></router-view>
    </div>
</template>

<script>
    export default {
        data() {
            return {
            }
        },

        methods: {
        }
    }
</script>

<style>
    #view{
        margin-top: 100px;
    }

    #app {
        font-family: Helvetica, sans-serif;
        text-align: center;
    }
</style>
