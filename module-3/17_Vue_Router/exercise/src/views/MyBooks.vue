<template>
  <div>
      <reading-list/>
      <router-link :to='{ name: "add-book" }'>New Book</router-link>
  </div>
</template>

<script>
import readingList from '../components/ReadingList.vue'
export default {
  components: { 
      readingList 
      }

}
</script>

<style>

</style>