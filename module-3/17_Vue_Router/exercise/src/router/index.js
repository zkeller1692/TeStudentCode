import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import MyBooks from '@/views/MyBooks.vue';
import AddBook from '@/views/NewBook.vue';
import Book from '@/views/BookDetails.vue'
Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component:Home
  },
  {
    path: '/myBooks',
    name: 'my-books',
    component: MyBooks
  },
  {
    path:'/addBook',
    name: 'add-book',
    component: AddBook
  },
  {
    path:'/book/:isbn',
    name: 'book',
    component: Book
  }

];

const router = new VueRouter({
  mode: 'history',
  routes
});

export default router;
