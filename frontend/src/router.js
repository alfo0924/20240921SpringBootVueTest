import { createRouter, createWebHistory } from 'vue-router'
import PageA from './views/PageA.vue'
import PageB from './views/PageB.vue'
import PageC from './views/PageC.vue'

const routes = [
    { path: '/', redirect: '/a' },
    { path: '/a', component: PageA },
    { path: '/b', component: PageB },
    { path: '/c', component: PageC }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
