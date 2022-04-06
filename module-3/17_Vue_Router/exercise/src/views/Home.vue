<template>
  <div>
      <new-releases-list/>
      <best-seller-list/>
  </div>
</template>

<script>
import bestSellerList from '@/components/BestSellerList.vue';
import newReleasesList from '@/components/NewReleasesList.vue';
export default {
    components: {
        bestSellerList,
        newReleasesList
    }
}
</script>

<style>

</style>