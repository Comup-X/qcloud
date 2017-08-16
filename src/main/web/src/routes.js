import faceCompare from './FaceCompare.vue'
import createPerson from './CreatePerson.vue'
import identifyPerson from './IdentifyPerson.vue'

const routes = [
    {path: "/faceCompare", component: faceCompare},
    {path: "/identifyPerson", component: identifyPerson},
    {path: "/createPerson", component: createPerson}
]

export default routes