
export default defineEventHandler(async (event) => {

    const title = getRouterParam(event, 'title')
    try {
        const response = await fetch(`http://localhost:8080/tickets/filter-by-title?title=${title}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('no available data');
        }

        return response
    } catch (error) {
        console.error('Error during fetch:', error);
    }

})