<template>
    <el-upload
            action=""
            :http-request="upload"
            :show-file-list="false">
        <img v-if="url" :src="url" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
</template>

<script>

    import ElUpload from 'element-ui'

    export default {

        extends: ElUpload,

        props: {
            folder: ''
        },

        watch: {
//            fileList(newValue, oldValue) {
//                debugger;
//                console.log('newValue is:' + newValue);
//            }
        },

        data() {
            return {
                url: '',
            }
        },

        methods: {
            upload(request) {
                this.cos.uploadFile(success => {
                        if (success.code === 0) {
                            this.url = success.data.source_url
                            this.$emit('success', this.url, this)
                        } else {
                            alert(success.message)
                        }
                    },
                    error => alert(error.message),
                    process => console.log(process),
                    this.cos.bucket, this.folder + request.file.name, request.file, 0);
            }
        }
    }
</script>

<style>

</style>