<template>
  <div id="app" class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <div class="actions">
      <router-link to='/'>Back to Products</router-link>&nbsp;|
      <router-link :to='{name: "add-review", params: { id: $store.state.activeProduct}}'>Add Review</router-link>
    </div>
    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>
    <review-list />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary.vue';
import StarSummary from '@/components/StarSummary.vue';
import ReviewList from '@/components/ReviewList.vue';

export default {
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    computed: {
      product(){
        return this.$store.state.products.find(p => p.id == this.$route.params.id);
      }  
    },
    created(){
        const productId = this.$route.params.id; //'id' matches :id from the path in the route
        console.log(`In created with id ${productId}`);
        this.$store.commit('SET_ACTIVE_PRODUCT', productId);
    }
}
</script>

<style>

</style>