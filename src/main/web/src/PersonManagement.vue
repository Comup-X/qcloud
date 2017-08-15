<template>
    <div>
        <div v-for="item in person">
            <el-row>{{item.name}}</el-row>
            <el-row>
                <el-upload
                        action=""
                        list-type="picture-card">
                    <i class="el-icon-plus"></i>
                </el-upload>
                <el-dialog v-model="dialogVisible" size="tiny">
                    <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
                <!--<cos-upload folder="/test/" listType="picture-card" fileList="item.files"></cos-upload>-->
            </el-row>
        </div>
        <el-button type="primary" @click="addPerson">添加个体</el-button>
    </div>
</template>

<script>
    import cosUpload from './CosUpload.vue'
    import axios from 'axios'

    export default {
        component: {
            'cos-upload': cosUpload
        },

        data() {
            return {
                person: [],
                fileList2: [{
                    name: 'food.jpeg',
                    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                }, {
                    name: 'food2.jpeg',
                    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                }]
            }
        },

        methods: {
            addPerson() {
                this.person.push({
                    name: '123',
                    files: [{
                        name: 'food.jpeg',
                        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                    }, {
                        name: 'food2.jpeg',
                        url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                    }]
                })
            },

            upload(file) {
                this.cos.uploadFile(success => {
                        if (success.code === 0) {
                            this.personAUrl = success.data.source_url
                        } else {
                            alert(success.message)
                        }
                    },
                    error => alert(error.message),
                    process => console.log(process),
                    this.cos.bucket, this.folder + file.name, file, 0);
                return false;
            }
        },

        created: () => {
            axios.get('http://127.0.0.1:8080/person/')
                .then(success => {
                    this.person = success
                })
                .catch(error => {
                    alert(error)
                });
        }
    }
</script>

<style>

</style>