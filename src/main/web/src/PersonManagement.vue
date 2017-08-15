<template>
    <div>
        <div v-for="item in person">
            <el-row>{{item.name}}</el-row>
            <cos-upload folder="/test/" listType="picture-card" fileList="item.files"></cos-upload>
        </div>
    </div>
</template>

<script>
    import cosUpload from './CosUpload.vue'

    export default {
        component: {
            'cos-upload': cosUpload
        },

        data() {
            return {
                person: {}
            }
        },

        methods: {
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
            this.axios.get('http://127.0.0.1:8080/person/')
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